function answer = RZ( theta )

	I = eye(2);
	Z = [1,0;0,-1];

	answer = cos(theta/2)*I - i*sin(theta/2)*Z;
endfunction
