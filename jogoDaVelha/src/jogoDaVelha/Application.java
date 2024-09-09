package jogoDaVelha;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		char jogador = 'X';
		char vencedor = 'A';
		int linha, coluna, cont, contaJogadas = 0;
		char[][] tabuleiro = new char[3][3];
		
		Scanner sc = new Scanner(System.in);
		
		while(vencedor != 'X' && vencedor != 'O' && vencedor != 'E') {
			System.out.println();
			System.out.println("Jogador " + jogador + ", é a sua vez!");
			System.out.println();
			System.out.print("Linha: ");
			linha = sc.nextInt();
			System.out.print("Coluna: ");
			coluna = sc.nextInt();
			System.out.println();
			
			if(linha >= 1 && linha <= 3 && coluna >= 1 && coluna <= 3) {
				
				if(tabuleiro[linha -1][coluna -1] != 'X' && tabuleiro[linha -1][coluna -1] != 'O') {
					tabuleiro[linha -1][coluna -1] = jogador;
				
					if(jogador == 'X') 
						jogador = 'O';
					else 
						jogador = 'X';
					
					contaJogadas++;
					
					if(contaJogadas == 9) 
						vencedor = 'E';
					
					for(cont=0; cont<3; cont++) {
						System.out.println(tabuleiro[cont][0] + " " + tabuleiro[cont][1] + " " + tabuleiro[cont][2]);
					}
					
					for(cont=0; cont<3; cont++) {
						
						if(tabuleiro[cont][0] == tabuleiro[cont][1] && tabuleiro[cont][1] == tabuleiro[cont][2])
							vencedor = tabuleiro[cont][0];
						
						if(tabuleiro[0][cont] == tabuleiro[1][cont] && tabuleiro[1][cont] == tabuleiro[2][cont]) 
							vencedor = tabuleiro[0][cont];
					}
					
					if(tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) 
						vencedor = tabuleiro[0][0];
					
					if(tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) 
						vencedor = tabuleiro[0][2];
				}else
					System.out.println("Posição ocupada!");
				
			}else 
				System.out.println("Posição indválida!");
		}
		
		if(vencedor == 'E') {
			System.out.println();
			System.out.println("O Jogo terminou empatado!");
		}else {
			System.out.println();
			System.out.println("Vencedor: Jogador " + vencedor);
		}
		
		sc.close();
		
	}

}
