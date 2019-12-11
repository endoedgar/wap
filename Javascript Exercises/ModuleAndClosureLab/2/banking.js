"use strict";
let accountInfoList = [];

let banking = (function() {
    function Account(accountName, deposit) {
        this.accountName = accountName;
        this.deposit = deposit;

        this.toStringx = function() {
            return "Account name:  " + this.accountName + "  Balance:  " + this.deposit;
        }
    }

    function updateTextArea() {
        let textArea = document.getElementById('textArea');
        textArea.value = "";
        for(let i in accountInfoList) {
            textArea.value += accountInfoList[i].toStringx() + "\n";
        }
    }

    return {
        createAccount: function() {
            let accountName = document.getElementById("accountName").value;
            let deposit = document.getElementById("deposit").value;
            accountInfoList.push(
                new Account(accountName, deposit)
            );
            updateTextArea();
        }
    };
})();