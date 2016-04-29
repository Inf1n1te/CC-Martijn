lexer grammar ID6;

//@header{package pp.block1.cc.antlr;}

fragment LETTER : ('a'..'z'|'A'..'Z');
fragment DIGIT : ('0'..'9');
fragment LETDIG : (LETTER|DIGIT);
WORD : LETTER LETDIG LETDIG LETDIG LETDIG LETDIG;
WS : [ \t\r\n]+ -> skip;
