(define habitat-material
	(lambda (height radius thickness)
		(let 
			(	(mypi 3.14159265)   )
				(let 
					((cylinder
						(lambda (r h)
							(* h (* mypi (* r r ))))))
					  (-
						(cylinder radius height)
						(cylinder	(- radius thickness) 
									(- height (* 2 thickness))	
						)	
					  )	
			    )	
		)	  
	)  	
)	
