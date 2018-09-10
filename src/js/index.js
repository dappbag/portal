//_utils.js
//_data.js


let vueApp = new Vue({
    el: '#vueEl',
    data: {
        categories: categories
    }

    , methods: {
        init: function () {
            // # rename this
            let t = this;

            log();

        }
    }
});


$(function () {
    try {
        vueApp.init();
    } catch (e) {
        log(e);
    }
});