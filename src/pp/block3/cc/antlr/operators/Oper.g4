grammar Oper;

import OperVocab;

t 	: t HAT t
	| t PLUS t
	| t EQUALS t
	| LPAR t RPAR
	| NUM
	| BOOL
	| STR
	;
