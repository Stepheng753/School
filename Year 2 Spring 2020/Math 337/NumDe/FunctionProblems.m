function z = FunctionProblems(t,y)

q = .0025*( 1+sin(2*pi*t/24) );
z = (q - 10*y)/1700;