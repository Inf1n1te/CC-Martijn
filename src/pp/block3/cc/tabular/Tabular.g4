grammar Tabular;

@header{package pp.block3.cc.tabular;}

table	: TABLE_START row* TABLE_END
		;
row		: col* lastcol ROW
		;
col		: STRING? COL
		;
lastcol	: STRING?
		;

fragment TABLE_DEF 	: [lcr];
fragment CHAR 		: [a-zA-Z0-9.,/?;:'"`()!@*-+=|];

TABLE_START	: WS* '\\begin{tabular}{'TABLE_DEF+'}' WS*;
TABLE_END	: WS* '\\end{tabular}' WS*;
ROW			: WS* '\\\\' WS*;
COL			: WS* '&' WS*;
STRING		: CHAR ((CHAR|WS)* CHAR)*;
WS 			: [ \t\n\r];

COMMENT		: WS* '%' WS* (CHAR | [ \t])* ('\r'|'\n') -> skip;
