<!--Begin::ExpectedEarningChart-->
<script>
// Class definition
    var ExpectedEarningChart = function () {
        // Private methods
        var initChart = function () {
            var el = document.getElementById('expected_earning_chart');
            if (!el) {
                return;
            }

            var options = {
                size: el.getAttribute('data-kt-size') ? parseInt(el.getAttribute('data-kt-size')) : 70,
                lineWidth: el.getAttribute('data-kt-line') ? parseInt(el.getAttribute('data-kt-line')) : 11,
                rotate: el.getAttribute('data-kt-rotate') ? parseInt(el.getAttribute('data-kt-rotate')) : 145,
                //percent:  el.getAttribute('data-kt-percent') ,
            }

            var canvas = document.createElement('canvas');
            var span = document.createElement('span');
            if (typeof (G_vmlCanvasManager) !== 'undefined') {
                G_vmlCanvasManager.initElement(canvas);
            }

            var ctx = canvas.getContext('2d');
            canvas.width = canvas.height = options.size;
            el.appendChild(span);
            el.appendChild(canvas);
            ctx.translate(options.size / 2, options.size / 2); // change center
            ctx.rotate((-1 / 2 + options.rotate / 180) * Math.PI); // rotate -90 deg

            //imd = ctx.getImageData(0, 0, 240, 240);
            var radius = (options.size - options.lineWidth) / 2;
            var drawCircle = function (color, lineWidth, percent) {
                percent = Math.min(Math.max(0, percent || 1), 1);
                ctx.beginPath();
                ctx.arc(0, 0, radius, 0, Math.PI * 2 * percent, false);
                ctx.strokeStyle = color;
                ctx.lineCap = 'round'; // butt, round or square
                ctx.lineWidth = lineWidth
                ctx.stroke();
            };
            // Init 
            drawCircle('#E4E6EF', options.lineWidth, 100 / 100);
            drawCircle(KTUtil.getCssVariableValue('--kt-danger'), options.lineWidth, 100 / 150);
            drawCircle(KTUtil.getCssVariableValue('--kt-primary'), options.lineWidth, 100 / 250);
        }

// Public methods
        return {
            init: function () {
                initChart();
            }
        }
    }();

// Webpack support
    if (typeof module !== 'undefined') {
        module.exports = ExpectedEarningChart;
    }

// On document ready
    KTUtil.onDOMContentLoaded(function () {
        ExpectedEarningChart.init();
    });

</script>
<!--End::ExpectedEarningChart-->

<!--Begin::AverageDailyChart-->
<script>
    // Class definition
    var AverageDailyChart = function () {
        // Private methods
        var initChart = function () {
            var element = document.getElementById("average_daily_chart");

            if (!element) {
                return;
            }

            var height = parseInt(KTUtil.css(element, 'height'));
            var labelColor = KTUtil.getCssVariableValue('--kt-gray-500');
            var borderColor = KTUtil.getCssVariableValue('--kt-border-dashed-color');
            var baseColor = KTUtil.getCssVariableValue('--kt-primary');
            var secondaryColor = KTUtil.getCssVariableValue('--kt-gray-300');

            var options = {
                series: [{
                        name: 'Sales',
                        data: [30, 60, 53, 45, 60, 75, 53]
                    }, ],
                chart: {
                    fontFamily: 'inherit',
                    type: 'bar',
                    height: height,
                    toolbar: {
                        show: false
                    },
                    sparkline: {
                        enabled: true
                    }
                },
                plotOptions: {
                    bar: {
                        horizontal: false,
                        columnWidth: ['55%'],
                        borderRadius: 6
                    }
                },
                legend: {
                    show: false,
                },
                dataLabels: {
                    enabled: false
                },
                stroke: {
                    show: true,
                    width: 9,
                    colors: ['transparent']
                },
                xaxis: {
                    axisBorder: {
                        show: false,
                    },
                    axisTicks: {
                        show: false,
                        tickPlacement: 'between'
                    },
                    labels: {
                        show: false,
                        style: {
                            colors: labelColor,
                            fontSize: '12px'
                        }
                    },
                    crosshairs: {
                        show: false
                    }
                },
                yaxis: {
                    labels: {
                        show: false,
                        style: {
                            colors: labelColor,
                            fontSize: '12px'
                        }
                    }
                },
                fill: {
                    type: 'solid'
                },
                states: {
                    normal: {
                        filter: {
                            type: 'none',
                            value: 0
                        }
                    },
                    hover: {
                        filter: {
                            type: 'none',
                            value: 0
                        }
                    },
                    active: {
                        allowMultipleDataPointsSelection: false,
                        filter: {
                            type: 'none',
                            value: 0
                        }
                    }
                },
                tooltip: {
                    style: {
                        fontSize: '12px'
                    },
                    x: {
                        formatter: function (val) {
                            return 'Feb: ' + val;
                        }
                    },
                    y: {
                        formatter: function (val) {
                            return val + "%"
                        }
                    }
                },
                colors: [baseColor, secondaryColor],
                grid: {
                    padding: {
                        left: 10,
                        right: 10
                    },
                    borderColor: borderColor,
                    strokeDashArray: 4,
                    yaxis: {
                        lines: {
                            show: true
                        }
                    }
                }
            };

            var chart = new ApexCharts(element, options);

            // Set timeout to properly get the parent elements width
            setTimeout(function () {
                chart.render();
            }, 300);
        }

        // Public methods
        return {
            init: function () {
                initChart();
            }
        }
    }();

// Webpack support
    if (typeof module !== 'undefined') {
        module.exports = AverageDailyChart;
    }

// On document ready
    KTUtil.onDOMContentLoaded(function () {
        AverageDailyChart.init();
    });

</script>
<!--End::AverageDailyChart-->

<!--Begin::RentsThisMonthChart-->
<script>
    // Class definition
    var RentsThisMonthChart = function () {
        var chart = {
            self: null,
            rendered: false
        };

        // Private methods
        var initChart = function (chart) {
            var element = document.getElementById("rents_this_month_chart");

            if (!element) {
                return;
            }

            var height = parseInt(KTUtil.css(element, 'height'));
            var labelColor = KTUtil.getCssVariableValue('--kt-gray-500');
            var borderColor = KTUtil.getCssVariableValue('--kt-border-dashed-color');
            var baseColor = KTUtil.getCssVariableValue('--kt-success');
            var lightColor = KTUtil.getCssVariableValue('--kt-success');

            var options = {
                series: [{
                        name: 'Sales',
                        data: [18, 18, 20, 20, 18, 18, 22, 22, 20, 20, 18, 18, 20, 20, 18, 18, 20, 20, 22]
                    }],
                chart: {
                    fontFamily: 'inherit',
                    type: 'area',
                    height: height,
                    toolbar: {
                        show: false
                    }
                },
                plotOptions: {

                },
                legend: {
                    show: false
                },
                dataLabels: {
                    enabled: false
                },
                fill: {
                    type: "gradient",
                    gradient: {
                        shadeIntensity: 1,
                        opacityFrom: 0.4,
                        opacityTo: 0,
                        stops: [0, 80, 100]
                    }
                },
                stroke: {
                    curve: 'smooth',
                    show: true,
                    width: 3,
                    colors: [baseColor]
                },
                xaxis: {
                    categories: ['', 'Apr 02', 'Apr 03', 'Apr 04', 'Apr 05', 'Apr 06', 'Apr 07', 'Apr 08', 'Apr 09', 'Apr 10', 'Apr 11', 'Apr 12', 'Apr 13', 'Apr 14', 'Apr 15', 'Apr 16', 'Apr 17', 'Apr 18', ''],
                    axisBorder: {
                        show: false,
                    },
                    axisTicks: {
                        show: false
                    },
                    tickAmount: 6,
                    labels: {
                        rotate: 0,
                        rotateAlways: true,
                        style: {
                            colors: labelColor,
                            fontSize: '12px'
                        }
                    },
                    crosshairs: {
                        position: 'front',
                        stroke: {
                            color: baseColor,
                            width: 1,
                            dashArray: 3
                        }
                    },
                    tooltip: {
                        enabled: true,
                        formatter: undefined,
                        offsetY: 0,
                        style: {
                            fontSize: '12px'
                        }
                    }
                },
                yaxis: {
                    tickAmount: 4,
                    max: 24,
                    min: 10,
                    labels: {
                        style: {
                            colors: labelColor,
                            fontSize: '12px'
                        },
                        formatter: function (val) {
                            return '$' + val + "K"
                        }
                    }
                },
                states: {
                    normal: {
                        filter: {
                            type: 'none',
                            value: 0
                        }
                    },
                    hover: {
                        filter: {
                            type: 'none',
                            value: 0
                        }
                    },
                    active: {
                        allowMultipleDataPointsSelection: false,
                        filter: {
                            type: 'none',
                            value: 0
                        }
                    }
                },
                tooltip: {
                    style: {
                        fontSize: '12px'
                    },
                    y: {
                        formatter: function (val) {
                            return "$" + val + "K"
                        }
                    }
                },
                colors: [lightColor],
                grid: {
                    borderColor: borderColor,
                    strokeDashArray: 4,
                    yaxis: {
                        lines: {
                            show: true
                        }
                    }
                },
                markers: {
                    strokeColor: baseColor,
                    strokeWidth: 3
                }
            };

            chart.self = new ApexCharts(element, options);

            // Set timeout to properly get the parent elements width
            setTimeout(function () {
                chart.self.render();
                chart.rendered = true;
            }, 200);
        }

        // Public methods
        return {
            init: function () {
                initChart(chart);

                // Update chart on theme mode change
                KTThemeMode.on("kt.thememode.change", function () {
                    if (chart.rendered) {
                        chart.self.destroy();
                    }

                    initChart(chart);
                });
            }
        }
    }();

// Webpack support
    if (typeof module !== 'undefined') {
        module.exports = RentsThisMonthChart;
    }

// On document ready
    KTUtil.onDOMContentLoaded(function () {
        RentsThisMonthChart.init();
    });
</script>
<!--End::RentsThisMonthChart-->