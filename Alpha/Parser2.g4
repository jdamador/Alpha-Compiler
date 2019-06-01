parser grammar Parser2;

options {
  tokenVocab = Scanner;
}

program : singleCommand EOF                                                     #programAST;
command : singleCommand (PyCOMA singleCommand)*                                 #commandAST;
singleCommand : ID  ASSIGN expression                                           #assignSCAST
        |        ID PIZQ expression PDER                                        #callSCAST
        | IF expression THEN singleCommand
                        ELSE singleCommand                                      #ifSCAST
        | WHILE expression DO singleCommand                                     #whileSCAST
        | LET declaration IN singleCommand                                      #letSCAST
        | BEGIN command END                                                     #beginSCAST;
declaration  : singleDeclaration (PyCOMA singleDeclaration)*                    #declarationAST;
singleDeclaration : CONST ID VIR expression                                     #constSTAST
    	   | VAR ID DOSPUN typeDenoter                                                   #varAST;
typeDenoter: ID                                                                 #typeDenoterAST;
expression : primaryExpression (operator primaryExpression)*                    #expressionAST;
primaryExpression : NUM                                                         #numPrimaryExpAST
                    |ID                                                         #idPrimaryExpAST
                     |(STRING | SPECIAL_STRING)                                 #stringPrimaryExpAST
                     | PIZQ expression PDER                                     #groupPEAST;
operator : SUM | SUB | MUL | DIV                                                #operatorAST;


