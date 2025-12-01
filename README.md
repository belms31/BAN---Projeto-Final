# Projeto Final de Banco de Dados

## Sistema de Hotel

Planeja-se criar um sistema de um hotel, focado nas operações diárias de
hospedagem, reservas, serviços e pagamentos. Sabe-se que os funcionários possuem seu
próprio número identificador no sistema e há dois tipos: os de recepção - cada reserva pode
ser registrada por um ou mais recepcionistas, enquanto um recepcionista pode agendar 0
ou mais estadias, visto que pode atuar em outras áreas da recepção - e os da limpeza - um
quarto deve ser limpo por uma ou mais funcionários dessa área, mas nem todo funcionário
precisa limpar quartos, visto que há outras áreas de hotel as quais precisam ser limpas.

Já um hóspede, registrado pelo seu cpf e é necessário saber seu nome, endereço e
telefone, pode reservar uma estadia - as quais podem ser reservadas por apenas um
hóspede e podem alocar um ou mais quartos - contendo data de entrada e de saída, além
de quantas pessoas irão ficar em cada quarto.

O hotel possui vários tipos de quartos (individual, Triplo, Suíte, entre outros), que
variam de preços e números de camas disponíveis. Cada quarto é reconhecido pelo seu
número e pode possuir nenhum ou um frigobar, o qual tem um status para indicar se está
cheio ou vazio e possui itens, que, se consumidos, são adicionados na conta junto com o
valor da estadia. O cliente pode escolher a forma de pagamento (débito, crédito, pix) e,
assim, finalizar sua estadia.

## Esquema Conceitual

## Esquema Lógico Relacional

## Aplicação sobre o BD Relacional
Por fim, devemos utilizar uma API Relacional para criar uma aplicação sobre o BD relacional proposto. 
Usamos 5 tabelas relacionadas: Estadia, Hospede, Funcionario, Reserva e Quarto.   
