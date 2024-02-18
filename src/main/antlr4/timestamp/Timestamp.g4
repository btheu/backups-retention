grammar Timestamp;

import Basic ;

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
expression : (YEAR) ;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
YEAR    : ( '19' | '20' ) DIGIT DIGIT ;

LETTERS : LETTER+ ;
NUMBER  : DIGIT+ ;

LETTER : UNICODE | [a-zA-Z] ;

fragment DIGIT   : [0-9] ;
fragment UNICODE : [àäâéèëêîïñôöûü%ç™!] ;
