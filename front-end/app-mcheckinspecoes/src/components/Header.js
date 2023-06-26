import React from 'react';
import {View, Text, StyleSheet} from 'react-native';
import { StatusBar } from 'expo-status-bar';

export default function Header() {
    return (
        <View style={styles.container}>
            <StatusBar style="auto" />
            <Text style={styles.text}>MCheck Inspeções</Text>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
    //   flex: 1, 
    //   justifyContent: 'flex-start', 
      alignItems: 'center',
    },
    text: {
        fontWeight: 'bold',
        fontSize: 20
    }
  });