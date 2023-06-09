import React from 'react';
import { StyleSheet, View, Text, TouchableOpacity, FlatList } from 'react-native';
import { Feather } from '@expo/vector-icons';

const InspecoesScreen = () => {
  // Lista de inspeções (exemplo)
  const inspecoes = [
    { id: 1, local: 'Local 1', data: '01/07/2023' },
    { id: 2, local: 'Local 2', data: '02/07/2023' },
    { id: 3, local: 'Local 3', data: '03/07/2023' },
  ];

  const MAX_LOCAL_LENGTH = 20;

  const handleDownloadPDF = (inspecao) => {
    // Lógica para realizar o download do PDF da inspeção
    console.log(`Download PDF - Inspeção ${inspecao.id}`);
  };

  const renderInspecaoItem = ({ item }) => {
    const localText = item.local.length > MAX_LOCAL_LENGTH ? `${item.local.slice(0, MAX_LOCAL_LENGTH)}...` : item.local;

    return (
      <View style={styles.inspecaoItem}>
        <View style={styles.textContainer}>
          <View style={styles.labelContainer}>
            <Text style={styles.label}>Local da inspeção: <Text style={styles.data}>{localText}</Text></Text>
          </View>
          <View style={styles.labelContainer}>
            <Text style={styles.label}>Data: <Text style={styles.data}>{item.data}</Text></Text>
          </View>
        </View>
        <TouchableOpacity
          style={styles.downloadIcon}
          onPress={() => handleDownloadPDF(item)}
        >
          <Feather name="download" size={24} color="#3cb371" />
        </TouchableOpacity>
      </View>
    );
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Inspeções</Text>
      <FlatList
        data={inspecoes}
        keyExtractor={(item) => item.id.toString()}
        renderItem={renderInspecaoItem}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'white'
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
    justifyContent: 'center',
    marginTop: 50,
    color: "#3cb371",   
  },
  inspecaoItem: {
    borderWidth: 1,
    borderColor: "#000c33",
    borderRadius: 8,
    padding: 10,
    marginBottom: 10,
    marginTop: 10,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    width: '100%'
  },
  textContainer: {
    flexDirection: 'column',
  },
  labelContainer: {
    marginRight: 10,
    padding: 5,
  },
  label: {
    fontSize: 16,
    fontWeight: 'bold',
<<<<<<< HEAD
    textAlign: 'left',
    color: "#000c33"
=======
    textAlign: 'left'
>>>>>>> 3f20efae2ad19ecc853de3a5bd27a4b1de39551d
  },
  localText: {
    fontSize: 16,
  },
  dataText: {
    fontSize: 14,
  },
  downloadIcon: {
    paddingLeft: 40
  },
  data:{
<<<<<<< HEAD
    color: 'gray',
  }
});

export default InspecoesScreen;
=======
    color: 'gray'
  }
});

export default InspecoesScreen;
>>>>>>> 3f20efae2ad19ecc853de3a5bd27a4b1de39551d
