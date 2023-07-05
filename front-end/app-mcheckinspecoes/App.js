import React from "react";
import { StatusBar } from 'expo-status-bar';
import { NavigationContainer } from "@react-navigation/native";
import EnterpriseScreen from "./src/screens/inspection/CadastroEmpresa";
import InspectionScreen from "./src/screens/inspection/CadastroInspecao";
import Signature from "./src/screens/inspection/AssinaturaInspecao";
import LoginScreen from "./src/screens/login/Login";
import CadastroScreen from "./src/screens/login/NovoUsuarioCadastro";
import CadastroSenhaScreen from "./src/screens/login/NovoUsuarioCadastroSenha";
import PerfilScreen from "./src/components/menu/Perfil";

export default function App() {
  return (
    <NavigationContainer>
      <StatusBar style="auto" />
      <PerfilScreen />
    </NavigationContainer>
  );
}

