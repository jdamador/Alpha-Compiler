lexer grammar Scanner;

// Symbols.
PyCOMA  : ';' ;
ASSIGN  : ':=';
PIZQ    : '(';
PDER    : ')';
VIR     : '~';
DOSPUN  : ':';
SUM     : '+';
SUB     : '-';
MUL     : '*';
DIV     : '/';
SMALLER : '<';
BIGGER  : '>';
SMALEQ  : '>=';
BIGEQ   : '<=';
EQUAL   : '==';
AND     : '&&';
OR      : '||';



// Key word for structures.
IF      : 'if' ;
WHILE   : 'while' ;
LET     : 'let';
THEN    : 'then';
ELSE    : 'else';
IN      : 'in';
DO      : 'do';
BEGIN   : 'begin';
END     : 'end';
CONST   : 'const';
VAR     : 'var';
PRINT   : 'print';
BOOL    : 'true'| 'false';
// Complex expressions
ID : LETTER (LETTER|DIGIT)* ;
NUM : DIGIT DIGIT* ;

STRING        :   '"' ('""'|~'"')* '"' ;
SPECIAL_STRING        :   '"''\\''"' ('""'|~'"')* '\\''"''"' ;

// Rules for build string and numbers.
fragment LETTER : 'a'..'z' | 'A'..'Z';
fragment DIGIT : '0'..'9' ;

// Skip white spaces.
WS  :   [ \t\n\r]+ -> skip ;

