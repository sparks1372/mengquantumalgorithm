function answer = RX( theta )

	I = eye(2);
	X = [0,1;1,0];

	answer = cos(theta/2)*I - i*sin(theta/2)*X;
endfunction
