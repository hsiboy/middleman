grammar Configuration;

@header {
package middleman.configuration;
}

@lexer::header {
package middleman.configuration;
}

configuration[MiddlemanConfiguration config]
	:	(configurationStatement[config])*
	EOF
	;
configurationStatement[MiddlemanConfiguration config]
	:	PORT EQ port=NUMBER { config.setConfigurationPort(Integer.parseInt(port.getText())); }
	|	def=proxyDefinition { config.add(def); }
	;

proxyDefinition returns [ProxyConfig proxy]
@init{ proxy = new ProxyConfig(); }
	:	PROXY name=IDENTIFIER {proxy.setName($name.getText());}BEGIN (proxyStatement[proxy])* END
	;
	
proxyStatement[ProxyConfig proxy]
	:	PORT EQ port=NUMBER {proxy.setPort(Integer.parseInt($port.getText()));}
	|	OUTPROXY EQ outproxy=STRING {proxy.setOutgoingProxy($outproxy.getText());}
	|	statement=stubStatement { proxy.add(statement); }
	|	DEBUG EQ debugLevel=NUMBER {proxy.setDebugLevel(Integer.parseInt($debugLevel.getText())); }
	;



stubStatement returns[StubResponse stub]
@init {
stub = new StubResponse();
}
  : STUB url=HOSTNAME {$stub.setUrl(url.getText()); }BEGIN (stubSetting[stub])* END ;


stubSetting[StubResponse stub]
	:	STATUSCODE EQ statusCode=NUMBER { stub.setStatusCode($statusCode.getText()); }
	|	HEADER EQ header=BLOCK {stub.setHeader($header.getText()); }
	|	BODY EQ body=BLOCK {stub.setBody($body.getText()); }
	;

PROXY	   :	'proxy';
BEGIN	   :	'{';
END	       :	'}';
STUB	   :	'stub';
PORT	   :	'port';
STATUSCODE :	'status-code';
HEADER	   :	'header';
BODY	   :	'body';
OUTPROXY   :	'outgoing-proxy';
DEBUG	   :	'debug';
OPENBLOCK : '[' ;
CLOSEBLOCK :  ']' ;
EQ : '=';

fragment DIGIT  : '0'..'9' ;

fragment LETTER : 'a'..'z' |'A'..'Z' ;

NUMBER : DIGIT+ ;

fragment WORD : LETTER+  ;

fragment SEPERATOR : '-' | '_';

// RFC 1034
fragment DNSCHAR : LETTER | DIGIT | '-' ;

IDENTIFIER  : ('0'..'9'| 'a'..'z'|'A'..'Z' | '_'|'-') ('_'|'-'|'a'..'z'|'A'..'Z'|'0'..'9')* ;

STRING : '"' ( '\\' . | ~('\\'|'"') )* '"'	;

URL : 'http://' (DNSCHAR | '\.' | ':'|'/')+ ;

HOSTNAME: ( NUMBER | WORD ) ( NUMBER | WORD | '-' | '_' )* ( '.' ( ( NUMBER | WORD ) ( NUMBER | WORD | '-' | '_' )* ) )*
  ;

BLOCK : OPENBLOCK (options {backtrack=true;} : BLOCK | ~CLOSEBLOCK)* CLOSEBLOCK	;


// Windows uses \r\n. UNIX and Mac OS X use \n.
NEWLINE: ('\r'? '\n')+ { skip(); };

WS : ( ' ' | '\u000C' | '\t' )+ { skip(); } ;
  
COMMENT
options { greedy = false; }    
    : '/*' .* '*/' NEWLINE? {skip();}
    ;

LINE_COMMENT: '//' ~('\r' | '\n')* NEWLINE { skip(); };
    