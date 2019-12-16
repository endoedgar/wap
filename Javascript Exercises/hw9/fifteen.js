"use strict";
$(document).ready(function() {
    let freeTile = 15;

    const getPositionVector = function(index) {
        return {
            x: ((index % 4) * 100),
            y: (Math.floor(index / 4) * 100)
        };
    };

    const areNeighbours = function(idA, idB) {
        return idA>=0 && idB>=0 && idA<16 && idB<16 &&idA != idB && ((Math.abs(idA-idB) <= 1 && Math.floor(idA/4) == Math.floor(idB/4)) || (Math.abs(idA-idB) <= 4 && idA%4 == idB%4));
    };

    const possibleNeighbours = function(id) {
        id = parseInt(id);
        const possibleNeighbours = [ id-1, id+1, id-4, id+4 ];
        let actualNeighbours = [];
        for(let i in possibleNeighbours)
            if(areNeighbours(id, possibleNeighbours[i]))
                actualNeighbours.push(possibleNeighbours[i]);
        return actualNeighbours;
    }

    const updateMovablePieces = function() {
        let $divs = $("div", $('#puzzlearea'));

        $divs.each(function() {
            $(this).removeClass('movablepiece');
            $(this).removeClass('valid');
            $(this).removeClass('invalid');

            if(areNeighbours($(this).attr('id'), freeTile)) { $(this).addClass('movablepiece'); }

            $(this).addClass( ($(this).attr('oid') == $(this).attr('id')) ? 'valid' : 'invalid' );
        });
    };

    const swap = function(id) {
        const $piece = $('#' + id);
        const oldId = $piece.attr('id');
        if(areNeighbours(oldId, freeTile)) {
            const freePosition = getPositionVector(freeTile);
            $piece.css({
                left: freePosition.x + 'px',
                top: freePosition.y + 'px',
            });
            $piece.attr('id', freeTile);
            freeTile = oldId;
            updateMovablePieces();
        }
    }

    const init = function() {
        const $puzzleArea = $('#puzzlearea');
        const $divs = $("div", $puzzleArea);
        
        // initialize each piece
        $divs.each(function(i) {
            const $div = $(this);
            
            // calculate x and y for this piece
            const pos = getPositionVector(i);

            // set basic style and background
            $div.addClass("puzzlepiece");
            $div.css({
                left: pos.x + 'px',
                top: pos.y + 'px',
                'background-image': 'url("background.jpg")',
                'background-position': -pos.x + 'px ' + (-pos.y) + 'px'
            });
            // store x and y for later
            $div.attr('id', i); 
            $div.attr('oid', i); 
            updateMovablePieces();

            $div.bind('click', function() {
                swap($(this).attr('id'));
            });
        });

        $('button#shufflebutton').click(function() {
            new Promise(function(resolve, reject){
                $(this).prop('disabled', true);
                const randomMoves = 100;
                for(let i = 0; i < randomMoves; ++i) {
                    const movablePieces = possibleNeighbours(freeTile);
                    const randomChoice = Math.floor(Math.random()*movablePieces.length);
                    swap(movablePieces[randomChoice]);
                }
                resolve($(this));
            }).then(function($elem) {
                $elem.prop("disabled", false);
            });
        });
    };

    init();
});