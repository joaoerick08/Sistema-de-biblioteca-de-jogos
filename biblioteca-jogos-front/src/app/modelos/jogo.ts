export interface Jogo {
  id?: number;
  nome: string;
  anoLancamento: number;
  pontuacao: number;
  avaliacaoPessoal: number;
  corLombada?: string;
  estudio: { id: number; nome?: string; pais?: string };
  categorias: { id: number; nome?: string }[];
}
