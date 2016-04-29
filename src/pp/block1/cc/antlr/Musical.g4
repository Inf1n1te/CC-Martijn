lexer grammar Musical;

//@header{package pp.block1.cc.antlr;}

fragment FLA : 'L' 'a'+ ' '* ;
LA : FLA ;
LALA : FLA FLA ;
LALALALI : FLA FLA FLA 'L' 'i' ' '* ;
