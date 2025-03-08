grammar sintaxisSimple;
@header{
    import java.util.HashMap;
}
@members{
    @Override
    public void displayRecognitionError(String[] tokenNames, RecognitionException e){
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e,tokenNames);
        System.out.println(">> My compiler >>"+hdr + " " + msg );

    }

    HashMap TSG = new HashMap();
    HashMap TSL = new HashMap();

    public void pushTSG(String id, String tipo){
        Integer se_encuentra = (Integer) TSG.get(id);
        if(se_encuentra==null){
            if(tipo.compareTo("int")==0) TSG.put(id,1);
            else if(tipo.compareTo("double")==0) TSG.put(id,2);
            else if(tipo.compareTo("class")==0) TSG.put(id,3);
            else if(tipo.compareTo("method")==0) TSG.put(id,4);
            else if(tipo.compareTo("void")==0) TSG.put(id,5);
        }
        else System.out.println("Error redeclarando :"+id);
    }
    public void pushTSL(String id, String tipo){
        Integer se_encuentra = (Integer) TSL.get(id);
        if(se_encuentra==null){
            if(tipo.compareTo("int")==0) TSL.put(id,1);
            else if(tipo.compareTo("double")==0) TSL.put(id,2);
            else System.out.println("Tipo desconocido...");
        }
        else System.out.println("Error redeclarando :"+id);
    }
     public void mostrarTSL() {
        System.out.println("Contenido de TSL:");
        for (Object key : TSL.keySet()) {
            System.out.println("ID: " + key + ", Tipo: " + TSL.get(key));
        }
    }
     public void mostrarTSG() {
        System.out.println("Contenido de TSG:");
        for (Object key : TSG.keySet()) {
            System.out.println("ID: " + key + ", Tipo: " + TSG.get(key));
        }
    }
    public void mostrarObjetoTSG(String id) {
        Integer tipo = (Integer) TSG.get(id);
        if (tipo != null) {
            System.out.println("ID: " + id + ", Tipo: " + tipo);
        } else {
            System.out.println("Error: ID no encontrado en TSG " + id);
        }
    }

    public boolean existeIdentificador(String id) {
        Integer tipoTsg = (Integer) TSG.get(id);
        if (tipoTsg != null) {
            System.out.println("Variable " + id + " encontrada en TSG con tipo: " + tipoTsg);
            return true;
        }
        
        Integer tipoTsl = (Integer) TSL.get(id);
        if (tipoTsl != null) {
            System.out.println("Variable " + id + " encontrada en TSL con tipo: " + tipoTsl);
            return true;
        }
        
        System.out.println("Error: La variable " + id + " no existe en ninguna tabla de símbolos");
        return false;
    }
    
    public int obtenerTipo(String id) {
        Integer tipoTsl = (Integer) TSL.get(id);
        if(tipoTsl != null) return tipoTsl;
        Integer tipoTsg = (Integer) TSG.get(id);
        if(tipoTsg != null) return tipoTsg;
        return 3; // tipo error
    }

    public boolean verificarTipos(String id1, int tipo2) {
        int tipo1 = obtenerTipo(id1);
        if(tipo1 != tipo2) {
            System.out.println("Error: tipos no coinciden en asignación - Variable " + id1 + 
                             " (tipo " + tipo1 + ") = expresión (tipo " + tipo2 + ")");
            return false;
        }
        return true;
    }

}

inicio: clase+ ;

clase: modificAcceso 'class' ID {pushTSG($ID.text, "class");}'{' miembro* '}' ; 

miembro: metodo | atributo  ;

atributo : (modificAcceso)? tipo id1= ID {pushTSG($id1.text, $tipo.text);}  (COMMA id2=ID {pushTSG($id2.text, $tipo.text);} )* SEMICOLON;

metodo: (modificAcceso)? tipo ID   '(' decl_args? ')'
        {
            // Si no hay modificador de acceso, tratarlo como protected
            if ($modificAcceso.text == null) {
                System.out.println("Usando protected por defecto para método: " + $ID.text);
            }
        }
        '{'
                instruccion*
        '}' {pushTSG($ID.text, "method");  TSL.clear();} ;
instruccion: asignacion | decl_local ;

asignacion: ID '='expr { 
    if(existeIdentificador($ID.text)) {
        verificarTipos($ID.text, $expr.tipo);
    }
} ';';

decl_args: t1=tipo id1=ID {pushTSL($id1.text, $t1.text);} (COMMA t2=tipo id2=ID {pushTSL($id2.text, $t2.text);})* ;

decl_local: tipo  id1=ID {pushTSL($id1.text, $tipo.text);} (',' id2=ID {pushTSL($id2.text, $tipo.text);})* SEMICOLON ;

expr returns [int tipo]: m1=multExpr{$tipo =$m1.tipo;} (('+'| '-') m2=multExpr{
    if($tipo != 3 && $m1.tipo != $m2.tipo) $tipo = 3;
    else if($tipo != 3) $tipo = $m1.tipo;
})*;

multExpr returns [int tipo]: a1=atom  {$tipo = $a1.tipo;} ('*' a2=atom {
    if($tipo != 3 && $a1.tipo != $a2.tipo) $tipo = 3;
    else if($tipo != 3) $tipo = $a1.tipo;
})* ;

atom returns [int tipo]: CINT {$tipo=1;}
                        | CDOUBLE  {$tipo=2;}
                        | ID  { 
                              Integer tipoTsl = (Integer) TSL.get($ID.text);
                              if (tipoTsl != null) {
                                  $tipo = tipoTsl;
                              } else {
                                  Integer tipoTsg = (Integer) TSG.get($ID.text);
                                  if(tipoTsg != null){
                                    $tipo = tipoTsg;
                                    mostrarObjetoTSG($ID.text);
                                  }else{
                                    System.out.println("No existe la variable "+$ID.text);
                                    $tipo = 3;
                                  }
                              }
                            }  
                        | '(' expr ')'{$tipo= $expr.tipo;} ;
modificAcceso: PUBLIC | PRIVATE | PROTECTED;
tipo: INT | DOUBLE | VOID;
INT: 'int';
DOUBLE: 'double';
VOID: 'void';
PUBLIC: 'public';
PRIVATE: 'private';
PROTECTED: 'protected';
ID: ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
WS: (' ' | '\n' | '\t' | '\r') + {$channel=HIDDEN;};
CDOUBLE: CINT'.'CINT ;
CINT: ('0' .. '9')+ ;
SEMICOLON: ';';
COMMA: ',';

// Un lenguaje que admita metodos y los metodos puras asignaciones con expresiones
//aritmeticas

/*
    public int idMetodo(){
        x = (b*x)/d+345.40;
    }

*/
