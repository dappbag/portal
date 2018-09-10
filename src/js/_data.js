let langs = {
    cn: {name: 'English', key: 'En'},
    en: {name: '中文', key: 'Cn'},
};
let categories = {
    gambling: {id: 1, name: 'Gamblings'},
    game: {id: 2, name: 'Games'},
    exchange: {id: 3, name: 'Exchanges'},
};

let chains = {
    eth: {id: 'ethereum', name: 'Ethereum'},
    btc: {id: 'btc', name: 'BTC'},
    eos: {id: 'eos', name: 'Eos'},
};

let games = {
    etheremon: {
        id: 'etheremon',
        categoryId: categories.gambling.id,
        name: 'etheremon',
        cover: '',
        addresses: ['0xabc1c404424bdf24c19a5cc5ef8f47781d18eb3e', '0x1fc7bd85293f3982f40d52698df8d26be89360d6'],
        showIndex: 1
    },
    cryptokitties: {
        id: 'cryptokitties',
        categoryId: categories.gambling.id,
        name: 'cryptokitties',
        cover: '',
        addresses: ['0xabc1c404424bdf24c19a5cc5ef8f47781d18eb3e', '0x1fc7bd85293f3982f40d52698df8d26be89360d6'],
        showIndex: 2
    },
};


