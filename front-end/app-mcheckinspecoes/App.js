import React from "react";
import { StatusBar } from 'expo-status-bar';
import { NavigationContainer } from "@react-navigation/native";
import MyDrawer from "./src/components/menu/Menu";
import Home from "./src/components/home/Home";

export default function App() {
  return (
    <NavigationContainer>
      <StatusBar style="auto" />
      <MyDrawer />
    </NavigationContainer>
  );
}


