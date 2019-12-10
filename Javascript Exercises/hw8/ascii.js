"use strict";
(function () { 
    let frames = [];
    let currentFrame = 0;
    let animationHandler;
    
    function createFrames(animation) { 
        return animation.split('=====\n'); 
    }

    function setupEventHandlers() {
        const btnStart = document.getElementById('btnStart');
        const btnStop = document.getElementById('btnStop');
        const selAnimation = document.getElementById('selAnimation');
        const selSize = document.getElementById('selSize');
        const chkTurbo = document.getElementById('chkTurbo');
        const myTextArea = document.getElementById('myTextArea');
    
        const animate = function() {
            myTextArea.value = frames[currentFrame];
            currentFrame = (currentFrame+1)%frames.length;
        };

        btnStart.onclick = function() {
            frames = createFrames(myTextArea.value);
            currentFrame = 0;
            animationHandler = setInterval(animate, chkTurbo.checked ? 50 : 250);
            btnStart.disabled = selAnimation.disabled = true;
            btnStop.disabled = false;
        };

        btnStop.onclick = function() {
            if(animationHandler)
                clearInterval(animationHandler);
            animationHandler = null;
            btnStart.disabled = selAnimation.disabled = false;
            btnStop.disabled = true;
        };

        selAnimation.onchange = function() { 
            myTextArea.value = ANIMATIONS[this.value]; 
        };

        selSize.onchange = function() {
            myTextArea.style.fontSize = this.value;
        };

        chkTurbo.onchange = function() {
            if(animationHandler) {
                clearInterval(animationHandler);
                animationHandler = setInterval(animate, this.checked ? 50 : 250);
            }
        };
    }

    window.onload = function() {
        setupEventHandlers();
    }; 
})();