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
      components.forEach((comp) => {
        const key = comp === "pc_case" ? "CASE" : comp.toUpperCase();
        data[key] = document.getElementById(comp).value;
      });

      console.log("Sending data:", data);

      try {
        const response = await fetch("/api/build", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(data),
        });

        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }

        const result = await response.json();
        console.log("Received response:", result);

        let output = `
<div class="result-box">
    <h1>
        <span class="white-text">Your</span>
        <span class="orange-box">PC</span>
    </h1>
    <ul>`;
        for (const key in result.components) {
          output += `<li><strong class="orange">${key}:</strong> ${result.components[key]}</li>`;
        }

        output += `</ul>
    <p><strong class="orange">Total price:</strong> ${result.totalPrice} UAH</p>`;

        if (
          result.compatibilityIssues &&
          Object.keys(result.compatibilityIssues).length > 0
        ) {
          output += `
    <div class="compatibility-issues">
        <h3 class="orange">Compatibility warnings:</h3>
        <ul>`;
          for (const key in result.compatibilityIssues) {
            output += `<li>${result.compatibilityIssues[key]}</li>`;
          }
          output += `</ul>
    </div>`;
        }

        output += `</div>`;

        document.getElementById("result").innerHTML = output;
        document.getElementById("result").classList.add("visible");
        document
          .getElementById("result")
          .scrollIntoView({ behavior: "smooth" });
      } catch (error) {
        console.error("Error:", error);
        document.getElementById("result").innerHTML =
          "<p>An error occurred while assembling your PC. " +
          "Make sure you have selected all of your PC components and try again.</p>";
        document.getElementById("result").classList.add("visible");
        document
          .getElementById("result")
          .scrollIntoView({ behavior: "smooth" });
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
