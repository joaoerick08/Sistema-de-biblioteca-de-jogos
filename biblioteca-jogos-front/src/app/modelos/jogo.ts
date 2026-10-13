export interface Jogo {
  id?: string;
  nome: string;
  anoLancamento: number;
  pontuacao: number;
  avaliacaoPessoal: number;
  corLombada?: string;
  estudio: { id: string; nome?: string; pais?: string };
  categorias: { id: string; nome?: string }[];
}
