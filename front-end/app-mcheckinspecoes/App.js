import React from "react";
import { StatusBar } from 'expo-status-bar';
import { NavigationContainer } from "@react-navigation/native";
import EnterpriseScreen from "./src/screens/inspection/CadastroEmpresa";
import InspectionScreen from "./src/screens/inspection/CadastroInspecao";
import Signature from "./src/screens/inspection/AssinaturaInspecao";

export default function App() {
  return (
    <NavigationContainer>
      <StatusBar style="auto" />
      <Signature />
    </NavigationContainer>
  );
}

