package Modelo;

import Obligatorio.Retorno;

public class ABBAfiliado {

    private NodoArbolAfiliado raiz;

    public ABBAfiliado() {
        this.raiz = null;
    }

    public ABBAfiliado(NodoArbolAfiliado raiz) {
        this.raiz = raiz;
    }

    public NodoArbolAfiliado getRaiz() {
        return raiz;
    }

    public NodoArbolAfiliado pertenece(String ci, Retorno ret) {
        return perteneceRec(ci, raiz, ret);
    }

    private NodoArbolAfiliado perteneceRec(String ci, NodoArbolAfiliado nodo, Retorno ret) {
        ret.valorEntero += 1;
        if (nodo == null) {
            return null;
        } else {
            if (ci == nodo.getCi()) {
                return nodo;
            } else if (formatearCi(ci) < formatearCi(nodo.getCi())) {
                return perteneceRec(ci, nodo.getIzq(), ret);
            } else {
                return perteneceRec(ci, nodo.getDer(), ret);
            }
        }
    }

    public void listarAscendente(Retorno ret) {
        listarAscendenteRec(raiz, ret);
        ret.valorString = ret.valorString.substring(0, ret.valorString.length()-1);
    }

    private void listarAscendenteRec(NodoArbolAfiliado nodo, Retorno ret) {
        if (nodo != null) {
            listarAscendenteRec(nodo.getIzq(), ret);
            ret.valorString += nodo.toString() + "|";
            listarAscendenteRec(nodo.getDer(), ret);
        }
    }
    
    public static void main(String [] args)
    {
        String ci = "4.771.266-2";
        
        System.out.println(ci.contains("."));
        System.out.println(ci.contains("-"));
        System.out.println(ci.split("[.]")[0]);
        String[] strings = ci.split("[.]");
        String[] strings2 = strings[2].split("-");
        System.out.println(Integer.parseInt(strings[0] + strings[1] + strings2[0] + strings2[1]));
    }
    
    public void insertar(String ci, String nombre, String email) {
        if (raiz == null) {
            raiz = new NodoArbolAfiliado(ci, nombre, email);
        } else {
            insertarRec(ci, nombre, email, raiz);
        }
    }

    private void insertarRec(String ci, String nombre, String email, NodoArbolAfiliado nodo) {
        if (formatearCi(ci) < formatearCi(nodo.getCi())) {
            if (nodo.getIzq() == null) {
                nodo.setIzq(new NodoArbolAfiliado(ci, nombre, email));
            } else {
                insertarRec(ci, nombre, email, nodo.getIzq());
            }
        } else if (formatearCi(ci) > formatearCi(nodo.getCi())) {
            if (nodo.getDer() == null) {
                nodo.setDer(new NodoArbolAfiliado(ci, nombre, email));
            } else {
                insertarRec(ci, nombre, email, nodo.getDer());
            }
        }
    }

    private int formatearCi(String ci) {
//        System.out.println(ci.contains("."));
//        System.out.println(ci.contains("-"));
//        System.out.println(ci.split(".")[0]);
//        String[] strings = ci.split(".");
//        String[] strings2 = strings[2].split('-');
        String[] strings = ci.split("[.]");
        String[] strings2 = strings[2].split("-");
        return Integer.parseInt(strings[0] + strings[1] + strings2[0] + strings2[1]);
//        String ret = "";
//        for (int i = 0; i < ci.length(); i++) {
//            if (ci.charAt(i) != '.' && ci.charAt(i) != '-') {
//                ret += ci.charAt(i);
//            }
//        }
//        return Integer.parseInt(ret);

    }

    public void destruir() {
        raiz = null;
    }
    

}

//<editor-fold defaultstate="collapsed" desc="Metodos comentados">
// Pre: !EsVacio()
//    public int borrarMinimo() {
//        if (raiz.getIzq() == null) {
//            int ret = raiz.getDato();
//            raiz = raiz.getDer();
//            return ret;
//        } else {
//            return borrarMinimoRec(raiz);
//        }
//    }
//    private int borrarMinimoRec(NodoArbolAfiliado nodo) {
//        if (nodo.getIzq().getIzq() == null) {
//            int ret = nodo.getIzq().getDato();
//            nodo.setIzq(nodo.getIzq().getDer());
//            return ret;
//        } else {
//            return borrarMinimoRec(nodo.getIzq());
//        }
//    }
// Pre: Pertenece(dato)
//    public void borrar(int dato) {
//        if (raiz.getDato() == dato) {
//            if (raiz.getIzq() == null && raiz.getDer() == null) { // Caso 1: F�cil
//                raiz = null;
//            } else if (raiz.getIzq() == null) { // Caso 2 (izq null): Maso
//                raiz = raiz.getDer();
//            } else if (raiz.getDer() == null) { // Caso 2 (der null): Maso
//                raiz = raiz.getIzq();
//            } else { // Caso 3
//                if (raiz.getDer().getIzq() != null) {
//                    raiz.setDato(borrarMinimoRec(raiz.getDer()));
//                } else {
//                    raiz.setDato(raiz.getDer().getDato());
//                    raiz.setDer(raiz.getDer().getDer());
//                }
//            }
//        } else {
//            borrarRec(dato, raiz);
//        }
//    }
//    private void borrarRec(int dato, NodoArbolAfiliado nodo) {
//        if (dato < nodo.getDato()) {
//            if (nodo.getIzq().getDato() == dato) {
//                if (nodo.getIzq().getIzq() == null && nodo.getIzq().getDer() == null) { // Caso 1: F�cil
//                    nodo.setIzq(null);
//                } else if (nodo.getIzq().getIzq() == null) { // Caso 2 (izq null): Maso
//                    nodo.setIzq(nodo.getIzq().getDer());
//                } else if (nodo.getIzq().getDer() == null) { // Caso 2 (der null): Maso
//                    nodo.setIzq(nodo.getIzq().getIzq());
//                } else { // Caso 3
//                    if (nodo.getIzq().getDer().getIzq() != null) {
//                        nodo.getIzq().setDato(borrarMinimoRec(nodo.getIzq().getDer()));
//                    } else {
//                        nodo.getIzq().setDato(nodo.getIzq().getDer().getDato());
//                        nodo.getIzq().setDer(nodo.getIzq().getDer().getDer());
//                    }
//                }
//            } else {
//                borrarRec(dato, nodo.getIzq());
//            }
//        } else if (dato > nodo.getDato()) {
//            if (nodo.getDer().getDato() == dato) {
//                if (nodo.getDer().getIzq() == null && nodo.getDer().getDer() == null) { // Caso 1: F�cil
//                    nodo.setDer(null);
//                } else if (nodo.getDer().getIzq() == null) { // Caso 2 (izq null): Maso
//                    nodo.setDer(nodo.getDer().getDer());
//                } else if (nodo.getDer().getDer() == null) { // Caso 2 (der null): Maso
//                    nodo.setDer(nodo.getDer().getIzq());
//                } else { // Caso 3
//                    if (nodo.getDer().getDer().getIzq() != null) {
//                        nodo.getDer().setDato(borrarMinimoRec(nodo.getDer().getDer()));
//                    } else {
//                        nodo.getDer().setDato(nodo.getDer().getDer().getDato());
//                        nodo.getDer().setDer(nodo.getDer().getDer().getDer());
//                    }
//                }
//            } else {
//                borrarRec(dato, nodo.getDer());
//            }
//        }
//    }
//    public void listarDescendente() {
//        listarDescendenteRec(raiz);
//        System.out.println();
//    }
//    private void listarDescendenteRec(NodoArbolAfiliado nodo) {
//        if (nodo != null) {
//            listarDescendenteRec(nodo.getDer());
//            System.out.println(nodo.getDato());
//            listarDescendenteRec(nodo.getIzq());
//        }
//    }

//</editor-fold>
