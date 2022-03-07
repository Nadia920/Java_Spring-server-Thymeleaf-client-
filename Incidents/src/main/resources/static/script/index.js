protocol = $(location).attr('protocol') + '//';
hostUrl = $(location).attr('host');
localServerUrl = protocol+hostUrl+'/';

$(document).ready(function () {
//timepicker

    $('#picker1').datetimepicker({
        timepicker: false,
        datepicker: true,
        format: 'Y-m-d',
        // value: '2019-12-26',
        weeks: true,
        yearStart: 2019,
        yearEnd: 2021
    });

    tail.select('#select1', {
        search: true,
        deselect: true
    });

    tail.select('#select2', {
        search: true,
        deselect: true
    });

function sendСonfirmPurchaseToEmail(order) {
    $.ajax({
        url: localServerUrl  + 'Travel/orders/sendСonfirmPurchaseToEmail',
        contentType: "application/json",
        method: "POST",
        data: JSON.stringify(order),
        success: function (order) {
            console.log("Data: " + order);
        },
        error: function (error) {
            console.log(status);
        },
        dataType: "json"
    });
}