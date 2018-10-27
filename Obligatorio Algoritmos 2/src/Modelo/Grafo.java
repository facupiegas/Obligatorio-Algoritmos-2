package Modelo;

public class Grafo {
    private Object[] vertices;
	private Arista[][] matAdy;
	private int tope;
	private int cantidad;

	public Grafo(int tope) {
		this.tope = tope;
		this.vertices = new Object[tope];
		this.matAdy = new Arista[tope][tope];
		for (int i = 0; i < tope; i++) {
			for (int j = i; j < tope; j++) {
				matAdy[i][j] = matAdy[j][i] = new Arista();
			}
		}

	}
	
	private int posOcupada() {
		for (int i = 0; i < tope; i++)
			if (vertices[i] != null)
				return i;
		return -1;
	}

	private int posLibre() {
		for (int i = 0; i < tope; i++)
			if (vertices[i] == null)
				return i;
		return -1;
	}

	// Pre: !existeVertice(ver) && !esLleno()
	public void agregarVertice(Object ver) {
		int pos = posLibre();
		vertices[pos] = ver;
		cantidad++;
	}

	// Pre: existeVertice(origen) && existeVertice(destino) &&
	// !existeArista(origen, destino)
	public void agregarArista(Object origen, Object destino, int peso) {
		int posOrigen = posVertice(origen);
		int posDestino = posVertice(destino);

		matAdy[posOrigen][posDestino].setExiste(true);
		matAdy[posOrigen][posDestino].setValor(peso);
	}

	public boolean esLleno() {
		return cantidad == tope;
	}

	private int posVertice(Object ver) {
		for (int i = 0; i < tope; i++)
			if (ver.equals(vertices[i]))
				return i;
		return -1;
	}

	public boolean existeVertice(Object ver) {
		return posVertice(ver) != -1;
	}

	public boolean existeArista(Object origen, Object destino) {
		int posOrigen = posVertice(origen);
		int posDestino = posVertice(destino);

		return matAdy[posOrigen][posDestino].isExiste();
	}

	// Pre: existeVertice(ver)
	public void borrarVertice(Object ver) {
		int pos = posVertice(ver);

		vertices[pos] = null;

		for (int i = 0; i < tope; i++) {
			matAdy[pos][i].setExiste(false);
			matAdy[i][pos].setExiste(false);
		}
	}

	public void borrarArista(Object origen, Object destino) {
		int posOrigen = posVertice(origen);
		int posDestino = posVertice(destino);

		matAdy[posOrigen][posDestino].setExiste(false);
		matAdy[posDestino][posOrigen].setExiste(false);
	}
	
	public void DFS(){
		boolean[] vis = new boolean[tope];
		int pos = posOcupada();
		if(pos != -1){
			for (int i = 0; i < tope; i++) {
				if(!vis[i] && vertices[i] != null)
				{
					DFSRec(i, vis);
				}
			}
		}
	}

	private void DFSRec(int pos, boolean[] vis) {
		vis[pos] = true;
		System.out.println(vertices[pos]);
		for (int i = 0; i < tope; i++) {
			if(!vis[i] && matAdy[pos][i].isExiste())
			{
				DFSRec(i, vis);
			}
		}
	}

	
	//Pre: !esVacio()
	public Grafo prim(){
		
		Grafo ret = new Grafo(tope);
		
		for (int i = 0; i < tope; i++) {
			if(vertices[i] != null)
			{
				ret.agregarVertice(vertices[i]);
			}
		}
		
		boolean[] vis = new boolean[tope];
		// for (int i = 0; i < tope; vis[i++]=false);
		
		vis[posOcupada()] = true;
		
		for (int k = 0; k < cantidad-1; k++) {
			
			int min = Integer.MAX_VALUE;
			int posOrigen = -1;
			int posDestino = -1;
			
			for (int i = 0; i < tope; i++) {
				if(vis[i])
				{
					for (int j = 0; j < tope; j++) {
						if(!vis[j] && matAdy[i][j].isExiste() && matAdy[i][j].getValor() < min)
						{
							min = matAdy[i][j].getValor();
							posOrigen = i;
							posDestino = j;
						}
					}
				}
			}
			
			ret.agregarArista(vertices[posOrigen], vertices[posDestino], min);
			vis[posDestino] = true;
			
		}
		
		return ret;
	}
	
	public int dijkstra(Object origen, Object destino)
	{
		int posO = posVertice(origen);
		int posD = posVertice(destino);
		
		// Etapa 1: Inicializo vectores
		int[] dist = new int[tope];
		int[] ant = new int[tope];
		boolean[] vis = new boolean[tope];
		
//		for (int i = 0; i < tope; ant[i] = -1,dist[i] = Integer.MAX_VALUE,i++);
		for (int i = 0; i < tope; i++){
			ant[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		
		dijkstraInterno(posO, dist, ant, vis);
		
		return dist[posD];
	}

	private void dijkstraInterno(int posO, int[] dist, int[] ant, boolean[] vis) {
		// Etapa 2: Actualizo las distancias de los adyacentes del origen
		dist[posO] = 0;
		vis[posO] = true;
		
		for (int i = 0; i < tope; i++) {
			if(matAdy[posO][i].isExiste())
			{
				dist[i] = matAdy[posO][i].getValor();
				ant[i] = posO;
			}
		}
		
		// Etapa 3: Proceso iterativo para actualizar distancias,
		//    actualizando aquellas aristas que marquen un mejor camino
		
		for (int k = 1; k < tope; k++) {
			// Elijo al pr�ximo vertice, siendo �ste el de menor distancia no visitada
			int posCand = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < tope; i++) {
				if(!vis[i] && dist[i]<min)
				{
					min = dist[i];
					posCand = i;
				}
			}
			
			// Si no hay candidato, no es conexo.
			if(posCand == -1)
				return;
			
			vis[posCand] = true;
			
			for (int i = 0; i < tope; i++) {
				if(!vis[i] && matAdy[posCand][i].isExiste())
				{
					int sumaDist = dist[posCand] + matAdy[posCand][i].getValor();
					if(sumaDist < dist[i])
					{
						dist[i] = sumaDist;
						ant[i] = posCand;						
					}
				}
			}
		}
	}
}
