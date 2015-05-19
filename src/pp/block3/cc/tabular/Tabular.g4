grammar Tabular;

@header{package pp.block3.cc.tabular;}

table	: TABLE_START rows TABLE_END
		;
rows	: ROW
		| ROW rows
		;

fragment TABLE_DEF 	: [lcr];
fragment CHAR 		: [a-zA-Z0-9.,/?;:'"`()!@*-+=|];

TABLE_START	: WS* '\\begin{tabular}{'TABLE_DEF+'}' WS*;
TABLE_END	: WS* '\\end{tabular}' WS*;
ROW			: STRING (WS* '&' WS* STRING)* WS* '\\' WS*;
COMMENT		: WS* '%' WS* (CHAR | [ \t])* ('\r'|'\n');
STRING		: CHAR ((CHAR|WS)* CHAR)*;
WS 			: [ \t\n\r];
