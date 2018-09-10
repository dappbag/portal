//built at 2018-09-08 17:17:20
let log = function () {
    console.log(arguments);
};
let langs = {
    cn: {name: 'English', key: 'En'},
    en: {name: '中文', key: 'Cn'},
};
let categories = {
    gambling: {id: 1, name: 'Gamblings'},
    game: {id: 2, name: 'Games'},
    exchange: {id: 3, name: 'Exchanges'},
};






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