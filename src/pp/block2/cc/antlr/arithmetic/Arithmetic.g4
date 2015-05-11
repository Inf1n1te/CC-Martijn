grammar Arithmetic;

@header{package pp.block2.cc.antlr.arithmetic;}

/* Expression */
expr : '(' expr ')' #exprPar
	| <assoc=right> expr OPERATORR expr #exprOpR
	| expr OPERATORL1 expr #exprOpL1
	| expr OPERATORL2 expr #exprOpL2
	| expr OPERATORMIN expr #exprMin
	| num #exprNum
	;
/* Number */
num : NUMBER #numPos
	| '-' num #numNeg
	;


NUMBER : '0' | ('1'..'9')('0'..'9')*;
OPERATORL1 : '/' | '*';
OPERATORL2 : '+';
OPERATORMIN : '-';
OPERATORR : '^';

// ignore whitespace
WS : [ \t\n\r] -> skip;

// everything else is a typo
TYPO : [a-zA-Z]+;
