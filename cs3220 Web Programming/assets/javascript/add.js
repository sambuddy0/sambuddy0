$(function() {
    $("#add").click(function() {
        let firstNumber = parseFloat($("#firstNumber").val());
        let secondNumber = parseFloat($("#secondNumber").val());

        if (isNaN(firstNumber) || isNaN(secondNumber)) {
            alert("Please enter valid numbers.");
            return;
        }

        let sum = firstNumber + secondNumber;

        $("#answer").text(sum);
    });
});