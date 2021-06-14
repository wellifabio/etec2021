const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const br = ["zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"];
const usa = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve ", " thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"];
var source;

rl.question("Digite o número que vai ser escrito por extenso:", function (value) {
    rl.question("Insira 1 para português e 2 para Inglês:\n", function (language) {
        if (language == 1) {
            source = br;
        } else {
            source = usa;
        }
        var espaco = "";
        if (language == 1) {
            espaco = " e ";
        } else {
            espaco = "-";
        }

        if (value <= 20) {
            console.log(source[value]);
        } else {
            const valueString = value.toString();
            var dezena = parseInt(valueString.substring(0, 1));
            dezena = 20 + dezena - 2;
            const unid = parseInt(valueString.substring(1, 2));
            if (unid == 0) {
                console.log(source[dezena]);
            }
            else {
                console.log(source[dezena] + espaco + source[unid]);
            }
        }
    });
});