var express = require('express');

var app = express();

app.get('/', function(req, res){
    res.contentType('json');
    res.json({name:"penus"})
});

app.listen(3000);