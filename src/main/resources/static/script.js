document.addEventListener("DOMContentLoaded", () => {
    const components = ["cpu", "gpu", "ram", "storage", "motherboard", "psu", "pc_case"];
    components.forEach(loadOptions);

    document.getElementById("build-form").addEventListener("submit", async (e) => {
        e.preventDefault();

        const data = {};
        components.forEach(comp => {
            const key = comp === "pc_case" ? "CASE" : comp.toUpperCase();
            data[key] = document.getElementById(comp).value;
        });

        console.log("Sending data:", data);

        try {
            const response = await fetch("/api/build", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(data)
            });

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const result = await response.json();
            console.log("Received response:", result);

            let output = `
    <div class="result-box">
        <h1>
            <span class="white-text">Ваш</span>
            <span class="orange-box">ПК</span>
        </h1>
        <ul>`;
            for (const key in result.components) {
                output += `<li><strong class="orange">${key}:</strong> ${result.components[key]}</li>`;
            }
            output += `</ul>
        <p><strong class="orange">Загальна ціна:</strong> ${result.totalPrice} грн</p>
    </div>`;
            document.getElementById("result").innerHTML = output;
            document.getElementById("result").classList.add("visible");
        } catch (error) {
            console.error("Error:", error);
            document.getElementById("result").innerHTML =
                "<p>Сталася помилка при збірці ПК. Будь ласка, спробуйте ще раз.</p>";
            document.getElementById("result").classList.add("visible");
        }
    });
});

async function loadOptions(component) {
    try {
        const response = await fetch(`/api/components/${component}`);
        if (!response.ok) {
            throw new Error(`Failed to load ${component} options`);
        }
        const data = await response.json();
        const select = document.getElementById(component);

        while (select.options.length > 1) {
            select.remove(1);
        }

        data.forEach(item => {
            const option = document.createElement("option");
            option.value = item.id;
            option.textContent = `${item.name} (${item.price} грн)`;
            select.appendChild(option);
        });
    } catch (error) {
        console.error(`Error loading ${component} options:`, error);
    }
}