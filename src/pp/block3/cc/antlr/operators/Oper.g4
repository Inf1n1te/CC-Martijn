grammar Oper;

import OperVocab;

@header{package pp.block3.cc.antlr.operators;}

t 	: t HAT t
	| t PLUS t
	| t EQUALS t
	| LPAR t RPAR
	| NUM
	| BOOL
	| STR
	;
