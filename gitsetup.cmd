: # The first time your clone your repository, you need to edit this file
: # so it can be used to configure the require git config options.
: # The lines that start :; are the ones to edit.

: # Once you have edited this file, you need to run it from a terminal window.
: # Open a terminal windows by going to the Terminal menu and choosing New Terminal.
: # On Linux or macOS, run with      sh ./gitsetup.cmd
: # On Windows, run with             .\gitsetup.cmd

: # Later on, if you clone your repository into another directory, you will need
: # to run this file again to set your git config options in that directory.

: # Remove :; from the next line, keep the quotes, change Pat Doe to your name
:; git config user.name "Pat Doe"

: # Remove :; from the next line, keep the quotes, change pat2345678@maricopa.edu to your email
:; git config user.email "pat2345678@maricopa.edu"

: # No changes needed on this line
git config pull.rebase true
