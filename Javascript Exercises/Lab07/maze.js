"use strict";
(function() {
    const GAME_RUNNING = 0;
    const GAME_WIN = 1;
    const GAME_LOSE = 2;
    let state;

    function setGameState(newState) {
        switch(state) {
            case GAME_WIN:
            case GAME_LOSE:
                if(newState == GAME_RUNNING) {
                    state = newState;
                }
                break;
            case GAME_RUNNING:
                switch(newState) {
                    case GAME_WIN:
                    case GAME_LOSE:
                        state = newState;
                        break;
                }
                break;
            default:
                state = newState;
                break;
        }
            
        switch(state) {
            case GAME_WIN:
                $('h2').text('You win! :]');
                break;
            case GAME_LOSE:
                $('.boundary').addClass('youlose');
                $('h2').text('Sorry, you lost. :[');
                break;
            case GAME_RUNNING:
                $('.boundary').removeClass('youlose');
                $('h2').text('');
                break;
        }
    }

    $(document).ready(function() {
        setGameState(GAME_RUNNING);

        $('.boundary').mouseover(function() {
            setGameState(GAME_LOSE);
        });

        $('#end').mouseover(function() {
            setGameState(GAME_WIN);
        });

        $('#start').click(function() {
            setGameState(GAME_RUNNING);
        });
        
        $('#maze').mouseleave(function(event) {
            setGameState(GAME_LOSE);
        });
    });
})();