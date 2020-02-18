package br.com.rsinet.hub.tdd.Utility;



public class Excel {
	
	
	
	public  String sUsuario() throws Exception {
	ExcelUtils.setExcelFile(
			"C:\\Users\\joice.abreu\\Desktop\\Dados.xlsx", "Planilha1");
		String sUsuario = ExcelUtils.getCellData(16, 0);
		return sUsuario;
	}

	public String sEmail() throws Exception {
		String sEmail = ExcelUtils.getCellData(1, 1);
		return sEmail;
	}

	public String sSenha() throws Exception {
		String sSenha = ExcelUtils.getCellData(1, 2);
		return sSenha;
	}
	public String s() throws Exception {
		String sConfirmarSenha = ExcelUtils.getCellData(1, 2);
		return sConfirmarSenha;
	}

	public String sConfirmarSenha() throws Exception {
		String sConfirmarSenha = ExcelUtils.getCellData(1, 2);
		return sConfirmarSenha;
	}

	public String sPrimeiroNome () throws Exception {
		String sPrimeiroNome = ExcelUtils.getCellData(1, 3);
		return sPrimeiroNome;
	}

	public String sUltimoNome() throws Exception {
		String sUltimoNome = ExcelUtils.getCellData(1, 4);
		return sUltimoNome;
	}

	public String sTelefone() throws Exception {
		String sTelefone = ExcelUtils.getCellData(1, 5);
		return sTelefone;
	}

	public String sPais() throws Exception {
		String sPais = ExcelUtils.getCellData(1, 6);
		return sPais;
	}

	public String sCidade() throws Exception {
		String sCidade = ExcelUtils.getCellData(1, 7);
		return sCidade;
	}

	public String sEndereco() throws Exception {
		String sEndereco = ExcelUtils.getCellData(1, 8);
		return sEndereco;
	}

	public String sEstado() throws Exception {
		String sEstado = ExcelUtils.getCellData(1, 9);
		return sEstado;
	}

	public  String sCep() throws Exception {
		String sCep = ExcelUtils.getCellData(1, 10);
		return sCep;
	}
	
	public String sLaptop() throws Exception {
		String sLaptop =ExcelUtils.getCellData(1, 11);
		return sLaptop;
	}
	
	public String sproduto() throws Exception {
		String sproduto =ExcelUtils.getCellData(1, 13);
		return sproduto;
	}
	public String sprodutoerrado() throws Exception {
		String sprodutoerrado =ExcelUtils.getCellData(1, 12);
		return sprodutoerrado;
	}

}
