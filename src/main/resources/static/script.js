document.addEventListener("DOMContentLoaded", () => {
  const components = [
    "cpu",
    "gpu",
    "ram",
    "storage",
    "motherboard",
    "psu",
    "pc_case",
  ];
  const selectedComponents = new Set();
  components.forEach((comp) => loadOptions(comp, selectedComponents));

  // Add component selection event listeners
  components.forEach((comp) => {
    const select = document.getElementById(comp);
    const infoBox = document.getElementById(`${comp}-info`);

    const defaultValue = select.value;
    if (defaultValue && defaultValue !== "") {
      const selectedOption = Array.from(select.options).find(
        (opt) => opt.value === defaultValue
      );
      if (selectedOption) {
        const tempItem = {
          id: selectedOption.value,
          name: selectedOption.text.split(" (")[0],
          price: selectedOption.text.match(/\((\d+) грн\)/)[1],
        };
        showComponentInfo(comp, defaultValue, tempItem);
      }
    }
  });

  document
    .getElementById("build-form")
    .addEventListener("submit", async (e) => {
      e.preventDefault();

      const data = {};
      const missingComponents = [];

      // Check for missing components
      components.forEach((comp) => {
        const select = document.getElementById(comp);
        const key = comp === "pc_case" ? "CASE" : comp.toUpperCase();
        const value = select.value;

        if (!value) {
          missingComponents.push(comp.replace("_", " ").toUpperCase());
        }
        data[key] = value;
      });

      // Show error if components are missing
      if (missingComponents.length > 0) {
        const missingList = missingComponents.join(", ");
        document.getElementById("result").innerHTML = `
          <div class="error-message">
            <h3>⚠️ Missing Components</h3>
            <p>Please select the following components to continue:</p>
            <ul>
              ${missingComponents.map((comp) => `<li>${comp}</li>`).join("")}
            </ul>
          </div>`;
        document.getElementById("result").classList.add("visible");
        document.getElementById("result").scrollIntoView({ behavior: "smooth" });
        return;
      }

      // Show loading state
      document.getElementById("result").innerHTML = `
        <div class="loading-message">
          <p>Building your PC configuration...</p>
          <div class="loading-spinner"></div>
        </div>`;
      document.getElementById("result").classList.add("visible");

      console.log("Sending data:", data);

      try {
        const response = await fetch("/api/build", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(data),
        });

        const result = await response.json();

        if (!response.ok) {
          throw new Error(result.message || `HTTP error! status: ${response.status}`);
        }

        console.log("Received response:", result);

        // Create a more detailed and organized display of the computer build
        let output = `
<div class="result-box">
    <h1>
        <span class="white-text">Your Custom</span>
        <span class="orange-box">PC Build</span>
    </h1>
    <div class="build-details">
        <div class="components-list">
            <h2 class="orange">Components:</h2>
            <ul>`;

        for (const key in result.components) {
          output += `
                <li>
                    <div class="component-item">
                        <strong class="orange">${key}:</strong>
                        <span class="component-name">${result.components[key]}</span>
                    </div>
                </li>`;
        }

        output += `
            </ul>
        </div>
        <div class="build-summary">
            <h2 class="orange">Build Summary</h2>
            <div class="total-price">
                <strong>Total Price:</strong>
                <span class="price-value">${result.totalPrice.toLocaleString()} UAH</span>
            </div>`;

        if (result.compatibilityIssues && Object.keys(result.compatibilityIssues).length > 0) {
          output += `
            <div class="compatibility-issues">
                <h3 class="orange">Compatibility Check:</h3>
                <ul class="issues-list">`;
          for (const key in result.compatibilityIssues) {
            output += `
                    <li class="issue-item">
                        <span class="warning-icon">⚠️</span>
                        ${result.compatibilityIssues[key]}
                    </li>`;
          }
          output += `
                </ul>
            </div>`;
        } else {
          output += `
            <div class="compatibility-success">
                <p>✅ All components are compatible!</p>
            </div>`;
        }

        output += `
        </div>
    </div>
</div>`;

        document.getElementById("result").innerHTML = output;
        document.getElementById("result").classList.add("visible");
        document.getElementById("result").scrollIntoView({ behavior: "smooth" });
      } catch (error) {
        console.error("Error:", error);
        document.getElementById("result").innerHTML = `
          <div class="error-message">
            <h3>⚠️ Error Building PC</h3>
            <p>An error occurred while assembling your PC:</p>
            <p class="error-details">${error.message}</p>
            <p>Please try again or contact support if the problem persists.</p>
          </div>`;
        document.getElementById("result").classList.add("visible");
        document.getElementById("result").scrollIntoView({ behavior: "smooth" });
      }
    });
});

async function loadOptions(component, selectedComponents) {
  try {
    const response = await fetch(`/api/components/${component}`);
    if (!response.ok) {
      throw new Error(`Failed to load ${component} options`);
    }
    const data = await response.json();
    const select = document.getElementById(component);
    const infoBox = document.getElementById(`${component}-info`);

    while (select.options.length > 0) {
      select.remove(0);
    }

    const emptyOption = document.createElement("option");
    emptyOption.value = "";
    emptyOption.textContent = "-- Select component --";
    select.appendChild(emptyOption);

    const itemsMap = {};

    data.forEach((item) => {
      const option = document.createElement("option");
      option.value = item.id;
      option.textContent = `${item.name} (${item.price} UAH)`;
      select.appendChild(option);
      itemsMap[item.id] = item;
    });

    select.addEventListener("change", () => {
      const selectedId = select.value;
      if (!selectedId || !itemsMap[selectedId]) {
        infoBox.classList.remove("visible");
        infoBox.innerHTML = "";
        return;
      }

      showComponentInfo(component, selectedId, itemsMap[selectedId]);

      if (!selectedComponents.has(component)) {
        selectedComponents.add(component);
        setTimeout(() => {
          window.scrollBy({
            top: 200,
            behavior: "smooth",
          });
        }, 100);
      }
    });
  } catch (error) {
    console.error(`Error loading ${component} options:`, error);
  }
}

function showComponentInfo(component, selectedId, item) {
  const infoBox = document.getElementById(`${component}-info`);
  let details = "<ul>";
  for (const key in item) {
    if (key === "id") continue;
    const formattedKey = key.replace(/_/g, " ").toUpperCase();
    details += `<li><strong>${formattedKey}:</strong> ${item[key]}</li>`;
  }
  details += "</ul>";
  infoBox.innerHTML = details;
  infoBox.classList.add("visible");
}
