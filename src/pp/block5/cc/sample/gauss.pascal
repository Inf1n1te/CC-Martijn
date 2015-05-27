Program gauss;

Var x: Integer;
	i: Integer;
	t: Integer;

Begin
	In("Upper bound? ", x);
	i := 1;
	t := 0;
	While i < x Do
	Begin
		t := t + i;
		i := i + 1
	End;
	Out("Total = ", t)
End.