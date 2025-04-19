document.addEventListener("DOMContentLoaded", () => {
    const components = ["cpu", "gpu", "ram", "storage", "motherboard", "psu", "pc_case"];
    components.forEach(loadOptions);

    document.getElementById("build-form").addEventListener("submit", async (e) => {
        e.preventDefault();

        const data = {};
        components.forEach(comp => {
            data[comp.toUpperCase()] = document.getElementById(comp).value;
        });

        const response = await fetch("/api/build", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(data)
        });

        const result = await response.json();

        let output = "<h2>Ваш ПК:</h2><ul>";
        for (const key in result.components) {
            output += `<li><strong>${key}:</strong> ${result.components[key]}</li>`;
        }
        output += `</ul><p><strong>Загальна ціна:</strong> ${result.totalPrice} грн</p>`;
        document.getElementById("result").innerHTML = output;
    });
});

async function loadOptions(component) {
    const response = await fetch(`/api/components/${component}`);
    const data = await response.json();
    const select = document.getElementById(component);
    data.forEach(item => {
        const option = document.createElement("option");
        option.value = item.id;
        option.text = `${item.name} (${item.price} грн)`;
        select.appendChild(option);
    });
}
