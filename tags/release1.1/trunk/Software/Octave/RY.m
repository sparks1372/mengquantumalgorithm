function answer = RY( theta )

	I = eye(2);
	Y = [0,-i;i,0];

	answer = cos(theta/2)*I - i*sin(theta/2)*Y;
endfunction
