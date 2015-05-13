grammar OperAttr;

import OperVocab;

@members {
	private Type getType(String input) {
		switch (input) {
			case "NUM":
				return Type.NUM;
			case "BOOL":
				return Type.BOOL;
			case "STR":
				return Type.STR;
			default:
				return Type.ERR;
		}
	}
}

t returns [(Type type, String value)]
	: 	t0=t HAT t1=t
		{}
	|	t0=t PLUS t1=t
		{}
	|	t0=t EQUALS t1=t
		{}
	|	'(' t=t ')'
		{}
	;
t returns [(Type type, String value)]
	:	NUM
		{ $type = getType("NUM"); }
		{ $value = $NUM.text; }
	|	BOOL
		{ $type = getType("BOOL"); }
        { $value = $BOOL.text; }
	|	STR
		{ $type = getType("STR"); }
        { $value = $STR.text; }
	;