grammar Oper;

import OperVocab;

t 	: t HAT t
	| t PLUS t
	| t EQUALS t
	| '(' t ')'
	| NUM
	| BOOL
	| STR
	;
