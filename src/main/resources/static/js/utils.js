
//Formats a box while it is being typed into.  Examples:
// 123 --> 123
// 1234 --> 1,234
// 1234.567 --> 1,234.56 (only two decimals are preserved)
// 1234.  -->  1,234.  (preserve the ., as need it to type.)
function formatInputAmount(amount) {
    var parts = amount.split('.');
    if (parts.length == 1) {
        return parseInt(amount).toLocaleString('en-US');
    } else {
        return parseInt(amount).toLocaleString('en-US') + '.' + parts[1].substring(0,2);
    }
}