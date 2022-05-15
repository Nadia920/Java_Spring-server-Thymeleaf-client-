/*protocol = $(location).attr('protocol') + '//';
hostUrl = $(location).attr('host');
localServerUrl = protocol+hostUrl+'/';

$(document).ready(function () {

    // input-spinner
    $("input[type='number']").inputSpinner();
    var $countTickets = $("#countTickets");
    var $returnTickets = $("#returnTickets");
    var $returnMoney = $('#returnMoney');
    var $priceOneSeat = $('#priceOneSeat');

    $returnTickets.attr("max", $countTickets.val());

    $returnTickets.on("change", function (event) {
        $returnMoney.val($returnTickets.val() * $priceOneSeat.val());
    });

    $('#returnBtn').on('click', function () {
        var returnTickets = $('#returnTickets').val();

        if (returnTickets == 0) {
            var va = "Enter count return tickets >0";
            $('#error_text').text(va);
            return;
        }
        var id = $('#order_id').val();

        var orderDTO = {
            "id": id,
            "returnTickets": returnTickets
        };

        console.log(JSON.stringify(orderDTO));
        $.ajax({
            url: localServerUrl + "Travel/orders/return",
            contentType: "application/json",
            method: "POST",
            data: JSON.stringify(orderDTO),
            success: function (order) {
                alert("You have successfully abandoned places. The money was returned.");
                url = localServerUrl + "Travel/orders/client";
                window.location.replace(url);
            },
            error: function (error) {
                if (error.status == 409) {
                    var error_msg = error.responseJSON.message;
                    $('#error_text').text(error_msg);
                }

            },
            dataType: "json"
        });

    });
});*/
let radio1 = document.getElementsByName("contact");
let radio2 = document.getElementsByName("contact2");
let radio3 = document.getElementsByName("contact3");
let value = 0;

if (radio1 == "Yes" ) { value++ }

if (radio2 == "8break45") { value++}

if (radio3 == "smallheels") {value++}

let proc = value/3 * 100
send = "Ваш результат равен " + proc + " процентов"

$.ajax({
url:"http://localhost:8080/tests/SendTestMoments?res="+proc,
method: "GET"
})


 $.ajax({
            url: localServerUrl + "SendTestMoments",
            contentType: "application/json",
            method: "POST",
            data: JSON.stringify(send),
            success: function (order) {

                url = "http://localhost:8080/Tests/Result";
                window.location.replace(url);
            },
            error: function (error) {
                if (error.status == 409) {
                    var error_msg = error.responseJSON.message;
                    $('#error_text').text(error_msg);
                }

            },
            dataType: "json"
        });
         $.ajax({
                    url: localServerUrl + "SendTestDiff",
                    contentType: "application/json",
                    method: "POST",
                    data: JSON.stringify(send),
                    success: function (order) {

                        url = localServerUrl + "SendTestDiff";
                        window.location.replace(url);
                    },
                    error: function (error) {
                        if (error.status == 409) {
                            var error_msg = error.responseJSON.message;
                            $('#error_text').text(error_msg);
                        }

                    },
                    dataType: "json"
                });