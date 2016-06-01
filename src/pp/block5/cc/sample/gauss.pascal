Program gauss;

Var arg, result, i: Integer;

Begin
	result := 0;
	In("Upper bound? ", arg);
	i := 1;
	While i <= arg Do
	Begin
		result := result + i;
		i := i + 1
	End;
	Out("Sum = ", result)
End.