const ctx = document.getElementById('productChart').getContext('2d');
let chart;

function showRequirements() {
    const productSelect = document.getElementById('productSelect');
    const productName = productSelect.value;

    if (productName === '') {
        alert('Please select a product');
        return;
    }

    const months = [
        'January', 'February', 'March', 'April', 'May', 'June',
        'July', 'August', 'September', 'October', 'November', 'December'
    ];

    let resultDiv = document.getElementById('result');
    resultDiv.innerHTML = `<h3>Requirements for ${productName}:</h3>`;

    let productData = [];

    months.forEach(month => {
        const requiredAmount = Math.floor(Math.random() * 500) + 1;
        productData.push(requiredAmount);

        const monthCard = `
            <div class="month-card">
                <span class="month">${month}</span>
                <span class="units">${requiredAmount} kg</span>
            </div>
        `;
        resultDiv.innerHTML += monthCard;
    });

    updateChart(productName, months, productData);
}

function updateChart(productName, labels, data) {
    if (chart) {
        chart.destroy();
    }

    chart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: `Monthly Requirement for ${productName}`,
                data: data,
                backgroundColor: 'lightgrey',
                borderColor: 'grey',
                borderWidth: 2,
                borderRadius: 10,
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: 'Units (kg)',
                        color: 'black'
                    },
                    ticks: {
                        color: 'black'
                    }
                },
                x: {
                    ticks: {
                        color: 'black'
                    }
                }
            },
            responsive: true,
            maintainAspectRatio: false
        }
    });
}
