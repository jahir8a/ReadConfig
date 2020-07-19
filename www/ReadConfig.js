var exec = require('cordova/exec');

module.exports.obtenerValorConfig = function (arg0, success, error) {
    exec(success, error, 'ReadConfig', 'obtenerValorConfig', [arg0]);
};
